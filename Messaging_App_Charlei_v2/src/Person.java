public class Person {
    String ip;
    int portNum;

    Person(String ip, int portNum){
        this.ip=ip;
        this.portNum=portNum;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPortNum() {
        return portNum;
    }

    public void setPortNum(int portNum) {
        this.portNum = portNum;
    }

    @Override
    public String toString() {
        return
                "IP='" + ip + '\'' +
                ", portNum=" + portNum ;
    }

} //CT
