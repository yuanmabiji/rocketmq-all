#### 1 新建一个rocketmq_home目录，下面再分别新建conf，logs和store三个文件夹；
#### 2 然后将myconf下的broker.conf，loback_broker.xml和loback_namesrv.xml复制到新建rocketmq_home目录下的conf目录下，注意修改三个配置文件实际的路径就行；
#### 3 编辑NamesrvStartup类的envirenment variables，制定rocketmq_home目录：ROCKETMQ_HOME=D:\code\rocketmq\rocketmq_home
#### 4 编辑BrokerStartup类的envirenment variables和program arguments参数：
envirenment variables：ROCKETMQ_HOME=D:\code\rocketmq\rocketmq_home
program arguments：-c D:\code\rocketmq\rocketmq_home\conf\broker.conf
##### 5 然后可以在D:\code\rocketmq\rocketmq_home\logs\rocketmqlogs目录下查看name server和broker的启动日志