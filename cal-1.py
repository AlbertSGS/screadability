import pandas as pd

# 读取合并后的CSV文件
df = pd.read_csv('./contract-all-info-new.csv', delimiter=',')

# 选择可读性指标列
readability_metrics = [
    'Avg-Assignment', 'Avg-blank-lines', 'Avg-commas', 'Avg-comments', 'Avg-comparisons', 
    'Avg-Identifiers-Length', 'Avg-conditionals', 'Avg-indentation-length', 'Avg-keywords', 
    'Avg-line-length', 'Avg-loops', 'Avg-number-of-identifiers', 'Avg-numbers', 'Avg-operators', 
    'Avg-parenthesis', 'Avg-periods', 'Avg-spaces', 'Max-Identifiers-Length', 'Max-indentation', 
    'Max-keywords', 'Max-line-length', 'Max-number-of-identifiers', 'Max-numbers', 'Max-char', 
    'Max-words', 'SLOC'
]

# 按 type 分组
grouped = df.groupby('type')

# 遍历每个 type 分组
for name, group in grouped:
    # 计算相关系数
    correlation = group[readability_metrics + ['ground truth']].corr()['ground truth'].drop('ground truth')
    correlation_sorted = correlation.sort_values(ascending=False)

    print(f"相关系数 ({name}):")
    print(correlation_sorted)
    
    # 保存到CSV文件
    correlation_sorted.to_csv(f'./correlation/{name}.csv', header=True)

    print(f"相关系数已保存到 'correlation_{name}.csv'")