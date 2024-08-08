import pandas as pd

# 读取CSV文件
df = pd.read_csv('temporary_output.csv', delimiter=';')

# 移除 Function-Name 列
df = df.drop(columns=['Function-Name'])

# 将列名分为 Avg 和 Max
avg_columns = [col for col in df.columns if col.startswith('Avg')]
max_columns = [col for col in df.columns if col.startswith('Max')]

# 按 Solidity-File 和 Contract-Name 分组，计算平均值、最大值和 SLOC 的总和
merged_df = df.groupby(['Solidity-File', 'Contract-Name']).agg(
    {**{col: 'mean' for col in avg_columns}, **{col: 'max' for col in max_columns}, 'SLOC': 'sum'}
).reset_index()

# 保存到新的CSV文件
merged_df.to_csv('merged_file.csv', index=False, sep=';')

print("合并后的文件已成功保存到 'merged_file.csv'!")