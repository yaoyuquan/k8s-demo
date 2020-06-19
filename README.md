# k8s-demo
基于k8s的服务注册发现

## 部署步骤

### 打包
```shell script
mvn clean package
```

### 部署eureka server
#### 构建镜像
```shell script
docker build --no-cache -t yaoyuquan/eureka-server .
```
#### 推送到docker仓库
```shell script
docker push yaoyuquan/eureka-server
```
#### 创建service
```shell script
kubectl apply -f service.yaml
```
#### 创建deployment
```shell script
kubectl apply -f deployment.yaml
```

### 部署producer
