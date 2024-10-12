package com.njkol;

import static org.junit.Assert.*;
import com.njkol.db.models.*;
import com.njkol.db.models.Product.Builder;

import org.junit.Test;

public class AvroTester {

	
	@Test
	public void testEquality() {
		
		Builder p1Buildr = Product.newBuilder();
		p1Buildr.setProductId(1);
		p1Buildr.setProductName("Horlicks");
		p1Buildr.setPrice(340.0f);
		p1Buildr.setProductCategory("Health");
		p1Buildr.setProductStatus(product_status.AVAILABLE);
		p1Buildr.setProductDescription("Health Drinks");

		Product p1 = p1Buildr.build();
		
		Builder p2Buildr = Product.newBuilder();
		p2Buildr.setProductId(1);
		p2Buildr.setProductName("Horlicks");
		p2Buildr.setPrice(340.0f);
		p1Buildr.setProductCategory("Health & Wellness");
		p1Buildr.setProductStatus(product_status.AVAILABLE);
		p1Buildr.setProductDescription("Health Drinks");
		
		Product p2 = p1Buildr.build();
		
		assertEquals(p1,p2);
	}
}
