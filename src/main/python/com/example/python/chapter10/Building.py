#! -*-coding:utf-8 -*-
from org.slf4j import LoggerFactory

from com.example.java.chapter10 import BuildingType

'''
注意事项：
1。python文件的路径不能和java文件的路径一致，否在在编译后会出现导包失败问题。
2. 需要修改pom文件，将python源码编译后放入classpath路径下，默认情况下python文件是不会放入classpath的，这样会出现文件不存在问题
3. 关于日志问题的处理，需要注意两点：
    1）在python文件中，class中的变量是静态的，需通过类名进行调用
    2）slf4j-log4j12的依赖，需要经scope注释掉，否则会出现问题
    3）要通过slf4j-log4j12的依赖，查找对应的log4j版本

'''

class Building(BuildingType):
    log = LoggerFactory.getLogger("Building")

    def __init__(self, buildingName, buildingAddress, buildingId):
        Building.log.info("python文件中Building对象进行初始化。。。 ")
        self.buildingName = buildingName
        self.buildingAddress = buildingAddress
        self.buildingId = buildingId

    def getBuildingName(self):
        Building.log.info("getBuildingName 方法被调用")
        return self.buildingName

    def getBuildingAddress(self):
        Building.log.info("getBuildingAddress 方法被调用")
        return self.buildingAddress

    def getBuildingId(self):
        Building.log.info("getBuildingId 方法被调用")
        return self.buildingId