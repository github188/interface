使用maven有部分库需要加到自己的本地仓库中，执行下面的命令添加本地库：

添加jdom 0.9到本地资源库的命令。 请将jdom.jar拷贝到d:\，然后执行下面命令:
mvn install:install-file -DgroupId=org.jdom -DartifactId=jdom -Dversion=0.9 -Dpackaging=jar -Dfile=d:\jdom.jar

添加ibatis 2.3.0.677到本地资源库的命令。 请将ibatis-2.3.0.677.jar拷贝到d:\，然后执行下面命令:
mvn install:install-file -DgroupId=com.ibatis -DartifactId=ibatis -Dversion=2.3.0.677 -Dpackaging=jar -Dfile=d:\ibatis-2.3.0.677.jar