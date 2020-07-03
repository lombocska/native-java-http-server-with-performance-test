package io.lombocska;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {

	private static final String INPUT_FILE = "/book/pride-and-prejudice-by-jane-austen.txt";
	private static final int NUMBER_OF_THREADS = 6;

	public static void main(String[] args) throws IOException {
		final String book = new String(Files.readAllBytes(Paths.get(App.class.getResource(INPUT_FILE).getPath())));

		startServer(book);
	}

	private static void startServer(final String book) throws IOException {
		final HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
		httpServer.createContext("/search", new WordCountHandler(book));

		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		httpServer.setExecutor(executor);
		httpServer.start();
	}
}
