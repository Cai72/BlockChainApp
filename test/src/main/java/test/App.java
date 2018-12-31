package test;
import java.io.File;
import java.math.BigInteger;
import java.sql.Time;
import java.util.List;

import javax.net.ssl.SSLException;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.geth.Geth;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

public class App {
	static Parity parity;
	static Web3j web3j;
	static Geth geth;
	static Admin admin;
    public static void main(String[] args) throws Exception {
    	System.out.println("请输入本地私链port端口(默认8545)");
		java.util.Scanner scanner=new java.util.Scanner(System.in);
		String port=scanner.nextLine();
        web3j = Web3j.build(new HttpService("http://localhost:"+port));
        parity=Parity.build(new HttpService("http://localhost:"+port));
        geth=Geth.build(new HttpService("http://localhost:"+port));
        admin=Admin.build(new HttpService("http://localhost:"+port));
    	System.out.println("接入私链成功,创建账户/登录账户:[0/1]");
    	String signal=scanner.nextLine();
    	if(signal.equals("0")) {
    		System.out.println("创建账户：请输入密码");
        	String code=scanner.nextLine();
        	Request<?,NewAccountIdentifier> request = parity.personalNewAccount(code);
        	NewAccountIdentifier result=null;
        	try {
                result = request.send();
                System.out.println("创建成功!你的账户地址是："+result.getAccountId());
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}else if(signal.equals("1")) {
    		System.out.println("登录账户：请输入账户地址");
        	String acc=scanner.nextLine();
        	List<String> temp=parity.ethAccounts().send().getAccounts();
        	if(temp.contains(acc)) {
        		System.out.println("登录账户：请输入账户密码");
            	String code=scanner.nextLine();
            	Request<?, PersonalUnlockAccount> request=geth.personalUnlockAccount(acc, code);
            	PersonalUnlockAccount result=request.send();
            	if(result.getResult()) {
            		System.out.println("登录成功,创建概率事件/加入概率事件/结束概率事件:[0/1/2]");
            		signal=scanner.nextLine();
            		System.out.println("请输入本地存放账户秘钥信息的路径如\"keystore\\\"");
            		File file=new File(scanner.nextLine());
        			String keystorepath="";
        			String tempacc=acc.replace("0x", "");
        			if(file.isDirectory()) {
        				File[] files=file.listFiles();
        				for(int i=0;i<files.length;i++) {
        					System.out.println(files[i].getName());
        					System.out.println(tempacc);
        					if(files[i].getName().contains(tempacc)) {
        						keystorepath="D:\\geth\\data0\\keystore\\"+files[i].getName();
        					}
        				}
        			}
        			Credentials credentials=WalletUtils.loadCredentials(code,keystorepath);
            		if(signal.equals("0")) {
            			System.out.println("创建概率事件...");
                		/*System.out.println("请输入gasPrice");
                		BigInteger gasPrice=new BigInteger(scanner.nextLine());
                		System.out.println("请输入gasLimit");
                		BigInteger gasLimit=new BigInteger(scanner.nextLine());*/
            			PEventPub pEventPub=PEventPub.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
            			System.out.println("请输入抽奖概率");
            			BigInteger pBigInteger=new BigInteger(scanner.nextLine());
            			System.out.println("请输入参与人数限制");
            			BigInteger plimitBigInteger=new BigInteger(scanner.nextLine());
            			System.out.println("请输入中奖人数限制");
            			BigInteger wlimitBigInteger=new BigInteger(scanner.nextLine());
            			TransactionReceipt res=pEventPub.init(pBigInteger, plimitBigInteger, wlimitBigInteger).send();
            			Thread.sleep(5);
            			System.out.println("创建成功");
            			System.out.println(res.toString());
            		}else if(signal.equals("1")) {
            			System.out.println("加入概率事件...请输入事件的合约地址:");
            			String contractAddress=scanner.nextLine();
            			PEventPub pEventPub=PEventPub.load(contractAddress, web3j, credentials, Contract.GAS_PRICE,Contract.GAS_LIMIT);
            			System.out.println("请输入要加入事件的账户地址");
            			TransactionReceipt res=pEventPub.giveRightToVote(scanner.nextLine()).send();
            			System.out.println("加入成功");
            			System.out.println(res.toString());
            		}else if(signal.equals("2")){
            			System.out.println("结束概率事件...请输入事件的合约地址:");
            			String contractAddress=scanner.nextLine();
            			PEventPub pEventPub=PEventPub.load(contractAddress, web3j, credentials, Contract.GAS_PRICE,Contract.GAS_LIMIT);
            			TransactionReceipt winners=pEventPub.finish().send();
            			System.out.println("事件已结束");
            			System.out.println(winners.toString());
            		}
            		else System.out.println("请输入0、1或2");
            	}else {
            		System.out.println("密码错误");
            	}
        	}else {
        		System.out.println("账户不存在");
        	}
    	}else {
    		System.out.println("请输入0或1");
    	}
    }
}