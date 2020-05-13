package com.example.java.chapter10;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingFactory {

    private static final Logger log = LoggerFactory.getLogger(BuildingFactory.class);
    private static BuildingFactory factory = null;
    //private BuildingFactory(){ }

    public static BuildingFactory getFactory(){
        log.info("通过工厂模式拿到buildingFactory对象");
        if(factory == null){
            factory = new BuildingFactory();
        }
        return factory;
    }

    private PyObject building;
    public BuildingFactory(){
        PythonInterpreter interpreter = new PythonInterpreter();
        //下面这两种方式都可以引入python文件
        //方式1：
        //String classPath = this.getClass().getResource("/").getPath();
        //interpreter.execfile(classPath.concat("com/example/python/chapter10/Building.py"));
        //方式2：
        interpreter.exec("from com.example.python.chapter10.Building import Building");
        building = interpreter.get("Building");
        log.info("从Building.py文件中拿到了文件的字节码对象");
    }

    private PyObject getBuilding(){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from com.example.python.chapter10.Building import Building");
        log.info("从Building.py文件中拿到了文件的字节码对象");
        return interpreter.get("Building");
    }


    public BuildingType create(String buildingName, String buildingAddress, String buildingId){
        if(building == null){
            log.info("文件的字节码对象为null，因此需要获取文件字节码对象");
            new BuildingFactory();
        }
        PyObject instance = building.__call__(new PyString(buildingName),
                new PyString(buildingAddress), new PyString(buildingId));
        return (BuildingType) instance.__tojava__(BuildingType.class);
//        PyObject instance = building.__call__();
//        BuildingType buildingType = (BuildingType) instance.__tojava__(BuildingType.class);
//        log.info("通过字节码对象创建Building对象， 并将其转换成java对象");
//        buildingType.setBuildingName(buildingName);
//        buildingType.setBuildingAddress(buildingAddress);
//        buildingType.setBuildingId(buildingId);
//        return buildingType;
    }

}
