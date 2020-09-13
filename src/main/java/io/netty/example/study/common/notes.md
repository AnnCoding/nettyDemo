#案例介绍和数据结构设计
客户端|传输结构|服务端
---:|:-----:|:---:
NettyClient|AuthOperation -> <br> <-AuthOperationResult <br> <br> OrderOperation ->  <br> <-OrderOperationResult <br> <br> KeepaliveOperation ->  <br> <-KeepaliveOperationResult <br> <br>  | NettyServer


## 网络传输的信息数据结构
|&emsp;|&emsp;|Frame|&emsp;|&emsp;
|:---|:-----|:---|:---|:---
&emsp;|Message|&emsp;|&emsp;|&emsp;
&emsp;|Message_Header|&emsp;|&emsp;|Message_body(JSON)
length|version|**opCode**|streamId|**operation/operation_result**

## 网络传输协议
> TCP网络传输协议
> 需要处理：半包，粘包，封帧 的问题 

## pom文件依赖
> netty
> lombok 生成get set 方法
> gson 解析json  
> guava

## common 文件相关的

 

      
 