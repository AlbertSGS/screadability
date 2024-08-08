import pandas as pd
import subprocess
import os
from tqdm import tqdm

df = pd.read_csv('dataset/all_data.csv')
print(df)

sc_list = [0]
for filename in os.listdir("dataset/all"):
    sc_list.append(filename)

print('len(sc_list): ',str(len(sc_list)))

all_result = []

java_command = [
            "java", "-jar", "iSCREAM-Replication-Package/target/iSCREAM-jar-with-dependencies.jar",
            "-p", f"dataset/all/",
            "-o", "temporary_output.csv"  # 临时输出文件
        ]

subprocess.call(java_command)

# for index, row in tqdm(df.iterrows()):
#     # if f"{row['file']}.sol" in sc_list:
#     #     subprocess.call(["java", "-jar", "iSCREAM-Replication-Package/target/iSCREAM-jar-with-dependencies.jar", "-p",
#     #                     f"dataset/all/{row['file']}.sol", "-o", f"dataset/{row['type']}/{row['file']}.csv"])
#     # else:
#     #     print(f"File {row['file']}.sol not found")
#     sol_file = f"{row['file']}.sol"
#     if sol_file in sc_list:
#         java_command = [
#             "java", "-jar", "iSCREAM-Replication-Package/target/iSCREAM-jar-with-dependencies.jar",
#             "-p", f"dataset/all/{sol_file}",
#             "-o", "temporary_output.csv"  # 临时输出文件
#         ]
#         subprocess.call(java_command)
#         temp_df = pd.read_csv("temporary_output.csv")
#         temp_df.insert(0, "type", row['type'])
#         temp_df.insert(0, "file", row['file'])

#         all_result = pd.concat([all_result, temp_df], ignore_index=True)

#     else:
#         print(f"File {sol_file} not found")

# all_result.to_csv('dataset/all_analysis_result.csv', index=False)
# print("Done!")