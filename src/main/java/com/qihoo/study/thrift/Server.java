package com.qihoo.study.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {
	private static final int SERVERPORT = 9099;
	private static final int TIMEOUT = 60000;

	public static void main(String[] args) throws TTransportException {
		Calculator.Processor<CalculatorImpl> processor = new Calculator.Processor<CalculatorImpl>(new CalculatorImpl());
		TServerTransport serverTransport = new TServerSocket(SERVERPORT, TIMEOUT);

		TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

		System.out.println("Starting db service......");
		server.serve();
		System.out.println("dsfdsf");
	}
}
