package io.lombocska;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordCountHandler implements HttpHandler {

	private final String book;

	public WordCountHandler(final String book) {
		this.book = book;
	}

	@Override
	public void handle(final HttpExchange exchange) throws IOException {
		final String query = exchange.getRequestURI().getQuery();
		final String [] keyValue = query.split("=");
		final String action = keyValue[0];
		final String word = keyValue[1];

		if (!action.equals("word")) {
			exchange.sendResponseHeaders(400, 0);
			return;
		}


		long count = countWord(word);

		byte [] response = Long.toString(count).getBytes();
		exchange.sendResponseHeaders(200, response.length);
		final OutputStream responseBody = exchange.getResponseBody();
		responseBody.write(response);
		responseBody.close();
	}

	private long countWord(final String word) {
		long count = 0;

		int index = 0;
		while (index >= 0) {
			index = book.indexOf(word, index);

			if (index >= 0) {
				count++;
				index++;
			}
		}
		return count;
	}
}
