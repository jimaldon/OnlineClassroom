<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/testmonial.css" />
<link rel="stylesheet" type="text/css" href="css/theme-style.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />

<!---- start-portfolio-script----->
			<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
		<script type="text/javascript">
						$(function () {
							var filterList = {
								init: function () {
				
									// MixItUp plugin
									// http://mixitup.io
									$('#portfoliolist').mixitup({
										targetSelector: '.portfolio',
										filterSelector: '.filter',
										effects: ['fade'],
										easing: 'snap',
										// call the hover effect
										onMixEnd: filterList.hoverEffect()
									});				
								
								},
								hoverEffect: function () {
									// Simple parallax effect
									$('#portfoliolist .portfolio').hover(
										function () {
											$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
											$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
										},
										function () {
											$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
											$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
										}		
									);				
							}
				
							};
						// Run the show!
						filterList.init();
						});	
					</script>
			<script src="js/prefixfree.min.js"></script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>
			<script type="text/javascript">
				$(window).load(function() {
				    $("#flexiselDemo3").flexisel({
				        visibleItems: 6,
				        animationSpeed: 1000,
				        autoPlay: true,
				        autoPlaySpeed: 3000,            
				        pauseOnHover: true,
				        enableResponsiveBreakpoints: true,
				        responsiveBreakpoints: { 
				            portrait: { 
				                changePoint:480,
				                visibleItems: 1
				            }, 
				            landscape: { 
				                changePoint:640,
				                visibleItems: 2
				            },
				            tablet: { 
				                changePoint:768,
				                visibleItems: 3
				            }
				        }
				    });
				    
				});
			</script>
			<script type="text/javascript">
				$(document).ready(function() {
					/*
					var defaults = {
			  			containerID: 'toTop', // fading element id
						containerHoverID: 'toTopHover', // fading element hover id
						scrollSpeed: 1200,
						easingType: 'linear' 
			 		};
					*/
					
					$().UItoTop({ easingType: 'easeOutQuart' });
			
				});
			</script>
			<!----//End-portfolio-script----->

</head>
<body>
<!----start-portfolio----->

<div id="port" class="portfolio portfolio-box">
              <div class="container">
    <h3>${course.courseTitle }</h3>
    <!----start-portfolio---->
    <div id="port" class="container portfolio-main">
                  <ul id="filters" class="clearfix">
        <li><span class="filter active" data-filter="app card icon logo web">All</span> /</li>
        <li><span class="filter" data-filter="app">DESIGN</span> /</li>
        <li><span class="filter" data-filter="card">PHOTOGRAPHY</span> /</li>
        <li><span class="filter" data-filter="icon">VIDEO</span> /</li>
        <li><span class="filter" data-filter="web">PRINT</span></li>
      </ul>
                  <div id="portfoliolist">
        <div class="portfolio logo1 mix_all" data-cat="logo" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p1.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Flat Pixel</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p2.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Radoslav holan</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio web mix_all" data-cat="web" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p3.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Apemanboards</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p4.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Flat Pixel</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p5.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Radoslav holan</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p6.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Apemanboards</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio icon mix_all" data-cat="icon" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p7.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Flat Pixel</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p8.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Radoslav holan</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                      <div class="portfolio-wrapper"> <a data-toggle="modal" data-target=".bs-example-modal-md" href="#" class="b-link-stripe b-animate-go  thickbox"> <img class="p-img" src="images/p2.jpg" />
                        <div class="b-wrapper">
                        <h2 class="b-animate b-from-left b-delay03"><img src="images/link-ico.png" alt=""/></h2>
                      </div>
                        </a> </div>
                      <div class="port-info">
            <h4><a href="#">Apemanboards</a></h4>
            <span>Website</span> </div>
                    </div>
        <div class="clearfix"> </div>
        <a class="more-ports text-center" href="#"><span> </span></a> </div>
                </div>
  </div>
              <div class="clearfix"> </div>
            </div>
<!----//End-portfolio----> 
</body>
</html>