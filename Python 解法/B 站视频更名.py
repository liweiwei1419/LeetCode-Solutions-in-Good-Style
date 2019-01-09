# @Time    : 18/4/29 上午11:38
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


import os
import json
import re


class BilibiliRename:

    def get_file_name(self, path, file):
        print(path, file)

        with open(os.path.join(path, file), 'r', encoding='utf-8') as f:
            json_str = f.readline()
            # print(json_str)
            obj = json.loads(json_str)
            # print(obj.get('PartName'))
            return obj.get('PartName')

    def rename_file(self, dir_name, orgin_name, new_name):
        # print(dir, orgin_name, new_name)

        matchObj = re.search('(.*)(_\d{1,2}.flv)', orgin_name)
        suffix = matchObj.group(2)

        origin_path = os.path.join(dir_name, orgin_name)
        new_path = os.path.join(dir_name, new_name + suffix)
        os.rename(origin_path, new_path)

    def deal_with(self, path):
        files = os.listdir(path)

        flv_path = list(filter(lambda f: f.endswith('.flv'), files))
        info_path = list(filter(lambda f: f.endswith('.info'), files))[0]
        file_name = self.get_file_name(path, info_path)
        # 给每一个 flv 文件改名
        for flv in flv_path:
            self.rename_file(path, flv, file_name)

        # 给目录改名
        origin_dir = path
        new_dir = os.path.join(path[:path.rfind('/')], file_name)
        os.rename(origin_dir, new_dir)


#
# root = "/Users/liwei/Downloads/a"
#


if __name__ == '__main__':
    root = '/Users/liwei/Downloads/a/'
    b = BilibiliRename()

    dirs = os.listdir(root)
    for d in dirs:
        if not d.isdigit():
            continue
        sub_path = os.path.join(root, d)
        # print(sub_path)
        b.deal_with(sub_path)

# import re
#
# a = '22631087_10_0.flv'
# matchObj = re.search('(.*)(_\d.flv)',a)
# ret = matchObj.group(2)
# print(ret)
