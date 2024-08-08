import pandas as pd

# 读取第一个CSV文件（原文件）
df_original = pd.read_csv('contract-readability.csv')

# 读取第二个CSV文件（包含ground truth信息）
df_ground_truth = pd.read_csv('contract-vulnerability.csv')

# 去掉第一个文件中 `Solidity-File` 列的 `.sol` 后缀
df_original['Solidity-File'] = df_original['Solidity-File'].str.replace('.sol', '', regex=False)

# 确保 `file` 列也是字符串类型
df_ground_truth['file'] = df_ground_truth['file'].astype(str)

# 根据 `Contract-Name` 和 `Solidity-File` 字段进行合并，添加 `ground truth` 和 `type` 列
df_merged = pd.merge(df_original, df_ground_truth[['contract', 'file', 'ground truth', 'type']], 
                     left_on=['Contract-Name', 'Solidity-File'], 
                     right_on=['contract', 'file'], 
                     how='left')

# 根据 contract 字段进行合并，添加 ground truth 和 type 列
# df_merged = pd.merge(df_original, df_ground_truth[['contract', 'ground truth', 'type']], 
#                      left_on='Contract-Name', right_on='contract', how='left')

# 删除多余的 contract 列
# df_merged = df_merged.drop(columns=['contract'])

# 删除多余的 `contract` 和 `file` 列
df_merged = df_merged.drop(columns=['contract', 'file'])

# 删除重复的行，确保每个 contract 和 file 组合唯一
df_merged = df_merged.drop_duplicates(subset=['Contract-Name', 'Solidity-File'])

# make sure all the ground truth values are integers
# df_merged['ground truth'] = df_merged['ground truth'].astype(int)

# 保存合并后的结果到新的CSV文件
df_merged.to_csv('contract-all-info-new.csv', index=False, sep=',')

print("合并后的文件已成功保存到 'merged_with_ground_truth_and_type.csv'!")