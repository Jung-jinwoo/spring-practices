package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	
	// @Autowired
	// 예외발생
	// XML Bean 설정(Avengers)에서는 id를 자동으로 부여하지 않는다
	// @Qualifier 사용 불가
	private DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan")
	private DigitalVideoDisc dvd2;
	
	@Autowired
	@Qualifier("avengersInfinityWar")
	private DigitalVideoDisc dvd3;
	
	@Autowired
	@Qualifier("avengersEndgame")
	private DigitalVideoDisc dvd4;
	
	@Autowired
	@Qualifier("avengersAgeofUltron")
	private DigitalVideoDisc dvd5;
	
	@Autowired
	@Qualifier("avengersCaptainAmerica")
	private DigitalVideoDisc dvd6;
	
	@Autowired
	@Qualifier("avengersDirectorEdition")
	private DigitalVideoDisc dvd7;
	
	@Ignore
	@Test
	public void testDvd1() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDvd2() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDvd3() {
		assertNotNull(dvd3);
	}
	
	@Test
	public void testDvd4() {
		assertNotNull(dvd4);
	}
	
	@Test
	public void testDvd5() {
		assertNotNull(dvd5);
	}
	
	@Test
	public void testDvd6() {
		assertNotNull(dvd6);
	}
	
	@Test
	public void testDvd7() {
		assertNotNull(dvd7);
	}
}
