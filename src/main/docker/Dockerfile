#指定基础镜像源,以其为基础进行制作
FROM adoptopenjdk/openjdk8:latest
# 维护者信息
MAINTAINER qhy
#将jar包添加到容器中
ADD demo-0.0.1-SNAPSHOT.jar mpdemo2des.jar
#对外暴露端口
EXPOSE 8090
# 运行jar包
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]