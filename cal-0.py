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

# 计算相关系数
correlation = df[readability_metrics + ['ground truth']].corr()['ground truth'].drop('ground truth')
correlation_sorted = correlation.sort_values(ascending=False)

# 输出相关系数
print(correlation_sorted)

import seaborn as sns
import matplotlib.pyplot as plt

# 绘制每个可读性指标与ground truth之间的箱线图
# plt.figure(figsize=(20, 30))
# for i, metric in enumerate(readability_metrics):
#     plt.subplot(7, 4, i+1)
#     sns.boxplot(x='ground truth', y=metric, data=df)
#     plt.title(f'{metric} vs. Ground Truth')
# plt.tight_layout()
# plt.show()

# 绘制散点图矩阵
# sns.pairplot(df, vars=readability_metrics, hue='ground truth', plot_kws={'alpha': 0.5})
# plt.show()