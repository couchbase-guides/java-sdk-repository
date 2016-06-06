package hello;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.EntityDocument;
import com.couchbase.client.java.repository.Repository;

public class Application {

	public static void main(String[] args) {
		CouchbaseCluster cc = CouchbaseCluster.create();
		Bucket bucket = cc.openBucket();
		Repository repository = bucket.repository();
		Customer content = new Customer("asmith", "Alice", "Smith");
		EntityDocument<Customer> document = EntityDocument.create(content);
		repository.upsert(document);
		
		EntityDocument<Customer> customerDocument = repository.get("asmith", Customer.class);
		Customer customer = customerDocument.content();
		System.out.println(customer);
	}


}
