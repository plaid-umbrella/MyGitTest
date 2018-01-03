package cn.spring.test.ws_client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CaClient {

	public static void main(String[] args) {

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

		String wsUrl = "http://localhost:8080/test/ws/WebServiceTest?wsdl";

		String method = "sayHai";

//		String method2 = "getNum";

		try {

			Client client = dcf.createClient(wsUrl);

			Object[] objects = client.invoke(method);

//			Object[] numbers = client.invoke(method2, 6);

			System.out.println(objects[0].toString());

//			System.out.println(numbers[0]);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
