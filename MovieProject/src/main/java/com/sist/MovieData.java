package com.sist;

public class MovieData {
	String mdata="1|쇼생크 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세 관람가|프랭크 다라본트\r\n"
			+ "2|원더|드라마|https://movie-phinf.pstatic.net/20171229_112/1514526663263n37r0_JPEG/movie_image.jpg?type=m77_110_2|제이콥 트렘블레이(어기 풀먼), 줄리아 로버츠(이자벨 풀먼), 오웬 윌슨(네이트 풀먼)|2017 .12.27 개봉|전체 관람가|스티븐 크보스키\r\n"
			+ "3|터미네이터 2|SF, 액션, 스릴러|https://movie-phinf.pstatic.net/20150618_223/1434606067675y97wa_JPEG/movie_image.jpg?type=m77_110_2|아놀드 슈왈제네거(터미네이터)|2015 .07.16 재개봉, 2013 .11.14 재개봉, 1991 .07.06 개봉|15세 관람가|제임스 카메론\r\n"
			+ "4|인생은 아름다워|드라마, 코미디|https://movie-phinf.pstatic.net/20160321_156/14585243498978uRh9_JPEG/movie_image.jpg?type=m77_110_2|로베르토 베니니(귀도), 니콜레타 브라스키(도라)|2016 .04.13 재개봉, 1999 .03.06 개봉|전체 관람가|로베르토 베니니\r\n"
			+ "5|매트릭스|SF, 액션|https://movie-phinf.pstatic.net/20160907_158/1473230958410gjEYe_JPEG/movie_image.jpg?type=m77_110_2|키아누 리브스(네오/토마스 앤더슨), 로렌스 피시번(모피어스), 캐리 앤 모스(트리니티)|2016 .09.22 재개봉, 1999 .05.15 개봉|12세 관람가|릴리 워쇼스키, 라나 워쇼스키\r\n"
			+ "6|레옹|범죄, 액션, 드라마|https://movie-phinf.pstatic.net/20130320_235/13637639244460lWSP_JPEG/movie_image.jpg?type=m77_110_2|장 르노(레옹), 나탈리 포트만(마틸다), 게리 올드만(스탠스 필드)|2013 .04.11 재개봉, 1998 .01.24 재개봉, 1995 .02.18 개봉|청소년 관람불가|뤽 베송\r\n"
			+ "7|위대한 쇼맨|드라마, 뮤지컬|https://movie-phinf.pstatic.net/20171218_47/1513561221134wvRja_JPEG/movie_image.jpg?type=m77_110_2|휴 잭맨(P.T. 바넘), 잭 에프론(필립 칼라일), 미셸 윌리엄스(채러티 바넘)|2017 .12.20 개봉|12세 관람가|마이클 그레이시\r\n"
			+ "8|포레스트 검프|드라마, 코미디|https://movie-phinf.pstatic.net/20160901_187/1472711688297YP2jH_JPEG/movie_image.jpg?type=m77_110_2|톰 행크스(포레스트 검프)|2016 .09.07 재개봉, 1994 .10.15 개봉|12세 관람가|로버트 저메키스\r\n"
			+ "9|죽은 시인의 사회|드라마|https://movie-phinf.pstatic.net/20160811_237/1470893687476y2lJU_JPEG/movie_image.jpg?type=m77_110_2|로빈 윌리엄스(존 키팅)|2016 .08.17 재개봉, 1990 .05.19 개봉|12세 관람가|피터 위어\r\n"
			+ "10|나 홀로 집에|모험, 범죄, 가족, 코미디|https://movie-phinf.pstatic.net/20111222_256/1324527530062tFbqt_JPEG/movie_image.jpg?type=m77_110_2|맥컬리 컬킨(케빈 맥콜리스터), 조 페시(좀도둑 해리 림), 다니엘 스턴(좀도둑 마브 머챈츠)|1991 .07.06 개봉|전체 관람가|크리스 콜럼버스\r\n"
			+ "11|월-E|애니메이션, SF, 가족, 코미디, 멜로/로맨스, 모험|https://movie-phinf.pstatic.net/20111222_250/1324545484806T0DN9_JPEG/movie_image.jpg?type=m77_110_2|벤 버트(월-E / M-O 목소리), 엘리사 나이트(이브 목소리), 제프 갈린(선장 목소리)|2008 .08.06 개봉|전체 관람가|앤드류 스탠튼\r\n"
			+ "12|빽 투 더 퓨쳐|SF, 코미디|https://movie-phinf.pstatic.net/20150924_194/1443056454769VJKkL_JPEG/movie_image.jpg?type=m77_110_2|마이클 J. 폭스(마티 맥플라이), 크리스토퍼 로이드(에메트 브라운 박사), 리 톰슨(로레인 베인스 맥플라이)|2015 .10.21 재개봉, 1987 .07.17 개봉|12세 관람가|로버트 저메키스\r\n"
			+ "";
	public Movie[]	movieAllData()
	{
		Movie[] movie =new Movie[12];
		String[] s= mdata.split("\r\n");
		for (int i=0; i<movie.length; i++)
		{
			for (String ss:s)
			{
				String[] d=ss.split("\\|");
				movie[i]=new Movie();
				movie[i].rank=d[0];
				movie[i].title=d[1];
				movie[i].genre=d[2];
				movie[i].poster=d[3];
				movie[i].director=d[4];
				movie[i].regdate=d[5];
				movie[i].grade=d[6];
				movie[i].director=d[7];
			}
		}
		return movie;
	}
	
}
