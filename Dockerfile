FROM openjdk:17
ADD target/hb-many-aws.jar hb-many-aws.jar
EXPOSE 8000
ENTRYPOINT [ "java","-jar","hb-many-aws.jar" ]