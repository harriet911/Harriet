from urllib import request

filep="https://qiye.163.com/public/images/banner/banner_20191022.jpg"
def downpic(filep):
    web = request.urlopen( filep)
    jpg=web.read()
    print("已请求"+filep)
    path=input("please input directory")
    try:
        File = open(path, "wb")
        File.write(jpg)
        File.close
        print("已保存图片")
    except BaseException:
        print("Error:文件出现异常")


    #print("已请求"+web)

if __name__ == "__main__":
    downpic(filep)
