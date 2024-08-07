import pandas as pd

excel_file_path = 'dataset/ground_truth_label.xlsx'

xls = pd.ExcelFile(excel_file_path)

dfs = [{"df": pd.read_excel(xls, index_col=None, sheet_name=sheet_name, usecols="A, B, C"), "type": sheet_name} for sheet_name in xls.sheet_names]

for i in range(len(dfs)):
    dfs[i]["df"].insert(0, "type", dfs[i]["type"])
    dfs[i] = dfs[i]["df"]

full_df = pd.concat(dfs, ignore_index=True)

full_df.to_csv('dataset/all_data.csv', index=False)