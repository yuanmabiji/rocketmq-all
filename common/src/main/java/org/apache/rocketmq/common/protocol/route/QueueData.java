/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * $Id: QueueData.java 1835 2013-05-16 02:00:50Z vintagewang@apache.org $
 */
package org.apache.rocketmq.common.protocol.route;

public class QueueData implements Comparable<QueueData> {
    private String brokerName; // 对应brokerName，即该queueData的元数据信息描述的就是该brokerName对应broker的元数据
    private int readQueueNums; // 读队列数量,对于消费者而言 【QUESTION1】一个Topic下有多个队列，这多个队列可否分布在不同的broker上呢？答：可以，但是跟writeQueueNums无关系，这里的writeQueueNums表示的是在同一个broker上建立多少个MessageQueue；为何有读队列和写队列？答：对于生产者或消费者而言的 【ANSWER1】
    private int writeQueueNums;// 写队列数量，对于生产者而言
    private int perm;// 读写权限
    private int topicSynFlag;

    public int getReadQueueNums() {
        return readQueueNums;
    }

    public void setReadQueueNums(int readQueueNums) {
        this.readQueueNums = readQueueNums;
    }

    public int getWriteQueueNums() {
        return writeQueueNums;
    }

    public void setWriteQueueNums(int writeQueueNums) {
        this.writeQueueNums = writeQueueNums;
    }

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }

    public int getTopicSynFlag() {
        return topicSynFlag;
    }

    public void setTopicSynFlag(int topicSynFlag) {
        this.topicSynFlag = topicSynFlag;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brokerName == null) ? 0 : brokerName.hashCode());
        result = prime * result + perm;
        result = prime * result + readQueueNums;
        result = prime * result + writeQueueNums;
        result = prime * result + topicSynFlag;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QueueData other = (QueueData) obj;
        if (brokerName == null) {
            if (other.brokerName != null)
                return false;
        } else if (!brokerName.equals(other.brokerName))
            return false;
        if (perm != other.perm)
            return false;
        if (readQueueNums != other.readQueueNums)
            return false;
        if (writeQueueNums != other.writeQueueNums)
            return false;
        if (topicSynFlag != other.topicSynFlag)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "QueueData [brokerName=" + brokerName + ", readQueueNums=" + readQueueNums
            + ", writeQueueNums=" + writeQueueNums + ", perm=" + perm + ", topicSynFlag=" + topicSynFlag
            + "]";
    }

    @Override
    public int compareTo(QueueData o) {
        return this.brokerName.compareTo(o.getBrokerName());
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }
}
