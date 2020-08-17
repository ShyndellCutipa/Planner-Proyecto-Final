<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/plugins/images/favicon.png">
    <title>Planner</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- Animation CSS -->
    <link href="assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet">
    <!-- color CSS you can use different color css from css/colors folder -->
    <!-- We have chosen the skin-blue (blue.css) for this starter
          page. However, you can choose any other skin from folder css / colors .
-->
    <link href="assets/css/colors/megna-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
	<%
		//allow access only if session exists
		if(session.getAttribute("user") == null){
			request.getRequestDispatcher("error.jsp")
			.forward(request, response);
		
		}
	%>
	   <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="fa fa-bars"></i></a>
                <div class="top-left-part"><a class="logo" href="inicio"><b><img src="assets/plugins/images/pixeladmin-logo.png" alt="home" /></b><span class="hidden-xs">Planner</span></a></div>
                <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Buscar..." class="form-control"> <a href=""><i class="fa fa-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <a class="profile-pic" href="#"><b class="hidden-xs">${user.first_name} ${user.last_name}</b> </a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="inicio" class="waves-effect"><i class="fa fa-home fa-fw" aria-hidden="true"></i><span class="hide-menu">Inicio</span></a>
                    </li>
                    <li>
                        <a href="guide.jsp" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i><span class="hide-menu">Guía</span></a>
                    </li>
                    <li>
                        <a href="profile.jsp" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i><span class="hide-menu">Perfil</span></a>
                    </li>
                    <li>
                        <a href="AdminImportantDate?action=mostrar" class="waves-effect"><i class="fa fa-calendar fa-fw" aria-hidden="true"></i><span class="hide-menu">Fechas Importantes</span></a>
                    </li>
                    <li>
                        <a href="AdminTask?action=mostrar" class="waves-effect"><i class="fa fa-list fa-fw" aria-hidden="true"></i><span class="hide-menu">To-Do</span></a>
                    </li>
                    <li>
                        <a href="AdminFavorite?action=mostrar" class="waves-effect"><i class="fa fa-star fa-fw" aria-hidden="true"></i><span class="hide-menu">Favoritos</span></a>
                    </li>
                    <!--<li>
                        <a href="blank.html" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                    </li>
                    <li>
                        <a href="404.html" class="waves-effect"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
                    </li>
                    -->
                </ul>
                <div class="center p-20">
                    <span class="hide-menu"><a href="logout"  class="btn btn-danger btn-block btn-rounded waves-effect waves-light">Salir</a></span>
                </div>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Inicio </h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12"> <a href="#" target="_blank" class="btn btn-danger pull-right m-l-20 btn-rounded btn-outline hidden-xs hidden-sm waves-effect waves-light"><i class="fa fa-refresh fa-fw" aria-hidden="true"></i></a>
                        <ol class="breadcrumb">
							<li><a href="inicio">Planner</a></li>
                            <li><a href="inicio">Inicio</a></li>
                            <li class="active">Estadísticas</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
				<div class="row">
						<div class="col-md-12">
			                    <div class="white-box">
			                            <h3 class="box-title">Estadísticas</h3> 
			                     </div>
			                 </div>
			             </div>
			             
			             
			             <!-- start here -->
			             
			             
			             <div class="row">
			                    <div class="col-md-4 col-sm-12 col-xs-12">
			                        <div class="white-box">
			                            <h3 class="box-title">Fechas Importantes</h3>
			                            
											<div class="weather-box">
					                                <div class="weather-top">
					                                    <h2 class="pull-left">${next_fechaimportante.title} <br>
					                  						<small><fmt:formatDate value="${next_fechaimportante.due_date}" pattern="dd MMM yyyy" /></small><br>
					                  						<small>${next_fechaimportante.priority}</small>
					                  					</h2>
					                                    <div class="today_crnt pull-right">
															<canvas class="sleet" width="44" height="44"></canvas> <span><sup><i class="fa fa-calendar"></i></sup></span>
														</div>
					                              	</div>
					                              	
             	
					                         </div>	
					                         
					                         <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-calendar"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD ALTA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-danger">${estadisticaID.cantidadIdAlto}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaID.cantidadIdAlto /(estadisticaID.cantidadIdAlto + estadisticaID.cantidadIdMedio + estadisticaID.cantidadIdBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	 
                                   			 <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-calendar"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD MEDIA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-info">${estadisticaID.cantidadIdMedio}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaID.cantidadIdMedio /(estadisticaID.cantidadIdAlto + estadisticaID.cantidadIdMedio + estadisticaID.cantidadIdBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	   
                                   			 <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-calendar"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD BAJA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-success">${estadisticaID.cantidadIdBajo}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaID.cantidadIdBajo /(estadisticaID.cantidadIdAlto + estadisticaID.cantidadIdMedio + estadisticaID.cantidadIdBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	                              
					                                             
			                            
			                        </div>
			                    </div>
			                    <div class="col-md-4 col-sm-12 col-xs-12">
			                        <div class="white-box">
			                            <h3 class="box-title">To - Do's</h3>
			                            	<div class="weather-box">
					                                <div class="weather-top">
					                                    <h2 class="pull-left">${next_tarea.title} <br>
					                  						<small><fmt:formatDate value="${next_tarea.due_date}" pattern="dd MMM yyyy" /></small><br>
					                  						<small>${next_tarea.priority}</small>
					                  					</h2>
					                                    <div class="today_crnt pull-right">
															<canvas class="sleet" width="44" height="44"></canvas> <span><sup><i class="fa fa-list"></i></sup></span>
														</div>
					                              	</div>
					                              	
             	
					                         </div>	
					                         
					                         <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-list"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD ALTA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-danger">${estadisticaTask.cantidadTAlto}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaTask.cantidadTAlto /(estadisticaTask.cantidadTAlto + estadisticaTask.cantidadTMedio + estadisticaTask.cantidadTBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	 
                                   			 <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-list"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD MEDIA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-info">${estadisticaTask.cantidadTMedio}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaTask.cantidadTMedio /(estadisticaTask.cantidadTAlto + estadisticaTask.cantidadTMedio + estadisticaTask.cantidadTBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	   
                                   			 <div class="col-in row">
                                        		<div class="col-md-6 col-sm-6 col-xs-6"> <i class="fa fa-list"></i>
                                            		<h5 class="text-muted vb"># PRIORIDAD BAJA</h5>
                                            	</div>
	                                        	<div class="col-md-6 col-sm-6 col-xs-6">
	                                            	<h3 class="counter text-right m-t-15 text-success">${estadisticaTask.cantidadTBajo}</h3>
	                                            </div>
	                                        	<div class="col-md-12 col-sm-12 col-xs-12">
		                                            <div class="progress">
		                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: ${estadisticaTask.cantidadTBajo/(estadisticaTask.cantidadTAlto + estadisticaTask.cantidadTMedio + estadisticaTask.cantidadTBajo) * 100}%"> <span class="sr-only">100% Complete (success)</span>
		                                                </div>
		                                            </div>
                                        		</div>
                                   			 </div>	
			                            
			                        </div>
			                    </div>
			                    <div class="col-md-4 col-sm-12 col-xs-12">
			                        <div class="white-box">
			                            <h3 class="box-title">Feeds</h3>
					                            <ul class="feeds">
					                                <li>
					                                    <div class="bg-info"><i class="fa fa-book text-white"></i></div>Libros: ${estadisticaFav.cantidadFLibro}  <span class="text-muted"></span></li>
					                                <li>
					                                    <div class="bg-success"><i class="fa fa-film text-white"></i></div>Peliculas: ${estadisticaFav.cantidadFPelicula}<span class="text-muted"></span></li>
					                                <li>
					                                    <div class="bg-warning"><i class="fa fa-globe text-white"></i></div>Lugar: ${estadisticaFav.cantidadFLugar}<span class="text-muted"></span></li>
					                                <li>
					                                    <div class="bg-danger"><i class="fa fa-cutlery text-white"></i></div>Restaurante:${estadisticaFav.cantidadFRestaurante}<span class="text-muted"></span></li>
					                                <li>
					                                    <div class="bg-inverse"><i class="fa fa-film text-white"></i></div> Serie: ${estadisticaFav.cantidadFSerie} <span class="text-muted"></span></li>
					                                <li>
					                                    <div class="bg-purple"><i class="fa fa-check text-white"></i></div> Ropa: ${estadisticaFav.cantidadFRopa} <span class="text-muted"></span></li>
					                            </ul>
			                           
			                        </div>
			                    </div>
			                </div>
			                
		                   <!-- end here -->
                            <!-- END MAGIC HERE -->
                            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2020 &copy; My Planner </footer>
        	</div>
        <!-- /#page-wrapper -->
    	</div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="assets/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="assets/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="assets/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="assets/js/custom.min.js"></script>
</body>

</html>
