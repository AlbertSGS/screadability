import pandas as pd
import plotly.graph_objects as go

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

# 创建节点和连接列表
labels = readability_metrics + list(grouped.groups.keys())
source = []
target = []
value = []

# 遍历每个 type 分组，计算相关系数并生成连接数据
for name, group in grouped:
    correlation = group[readability_metrics + ['ground truth']].corr()['ground truth'].drop('ground truth')
    for metric in readability_metrics:
        source.append(labels.index(metric))
        target.append(labels.index(name))
        value.append(abs(correlation[metric]))  # 取绝对值表示相关性强度

# 创建桑基图
fig = go.Figure(data=[go.Sankey(
    node=dict(
        pad=15,
        thickness=20,
        line=dict(color="black", width=0.5),
        label=labels,
    ),
    link=dict(
        source=source,
        target=target,
        value=value,
    ))])

fig.update_layout(title_text="Readability Metrics and Vulnerability Types Correlation", font_size=10)
fig.show()

# 保存图表为 PDF 文件
# fig.write_image("readability_metrics_vulnerability_types_correlation.png")