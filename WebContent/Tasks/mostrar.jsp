<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="fa fa-bars"></i></a>
                <div class="top-left-part"><a class="logo" href="index.html"><b><img src="assets/plugins/images/pixeladmin-logo.png" alt="home" /></b><span class="hidden-xs">Planner</span></a></div>
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
                        <h4 class="page-title">Tareas</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="inicio">Planner</a></li>
                            <li><a href="AdminTask?action=mostrar">To-Do</a></li>
                            <li class="active">Mis Tareas</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                                	<div class = "white-box">
                <div class="row">

                    <div class="col-sm-8">
                    	<h3>Mis Tareas</h3>
                    		<form action="AdminTask?action=filtrar" method="post">
                                <div class="form-group">
                                    <label for="exampleInputpwd1">Prioridad</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-arrows-v"></i></div>
                                          <select name="priority" id="priority" class="form-control">
		                                      <option>Todos</option>
		                                      <option>Bajo</option>
		                                      <option>Medio</option>
		                                      <option>Alto</option>
                                			</select>
                                		</div>
                                </div>
                             	
                                <button type="submit" name="btn-action" float = "center" class="btn btn-megna waves-effect waves-light m-r-10">Filtrar</button>
                            </form>
                       </div>
                   </div>
                </div>        
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-6">
                            
                            <div class="card">
								<!-- DO MAGIC HERE -->
							    <div class="card-conteiner">
							    
							    	<c:forEach var="tarea" items="${listTasks}">
							    		<div class="white-box">
								    		<a href="#" class="btn btn-default btn-circle" style="float: left;"><i<h4><strong><c:out value="${tarea.id_task}"/>.</strong></h4> </i></a>
								    		<a class="label label-${tarea.priority.equals('Alto') ? 'danger': (tarea.priority.equals('Medio') ? 'info' :'success') } label-rounded" style="float: right;" ><c:out value="${tarea.priority}"/></a><br>
								    		<br>
									        <h5 class="card-title"><input type="checkbox">&nbsp<c:out value="${tarea.title}"/></h5>
									        <p class="card-text"><c:out value="${tarea.description}"/></p>
									        <a href="AdminTask?action=editar&id_task=${tarea.id_task}" data-toggle="tooltip" data-original-title="Edit" style="float: right;"> <i class="fa fa-pencil text-inverse m-r-10"></i> </a>
									        
								        </div>
								    </c:forEach>
								
								
								
								
								<!-- END MAGIC HERE -->
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="white-box">
                            <h3 class="box-title">Avance</h3>
                           	<a href="AdminTask?action=nuevo" class="btn btn-danger btn-circle" style="float: right;"><i class="fa fa-plus"></i></a>
                            <br><br>
								<!-- DO MAGIC HERE -->
                            
	                            <div class="table-responsive">
	                            <table class="table color-table danger-table" >
	                            <thead>
		                            <tr>
										<!-- <th>#</th>-->
										<th>Título</th>
										<!-- <th>Descripcion</th>-->
										<th>Fecha</th>
										<th>Prioridad</th>
										<th colspan=2>ACCIONES</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tarea" items="${listTasks}">
										<tr>
											<!-- <td><c:out value="${tarea.id_task}"/></td>-->
											<td><c:out value="${tarea.title}"/></td>
											<!-- <td><c:out value="${tarea.description}"/></td>-->
											<td><fmt:formatDate value="${tarea.due_date}" pattern="dd MMM yyyy" /></td>
											<td><span class="label label-${tarea.priority.equals('Alto') ? 'danger': (tarea.priority.equals('Medio') ? 'info' :'success') } label-rounded"><c:out value="${tarea.priority}"/></span></td>
											<td>
												<a href="AdminTask?action=editar&id_task=${tarea.id_task}" data-toggle="tooltip" data-original-title="Edit"> <i class="fa fa-pencil text-inverse m-r-10"></i> </a>
												<a href="AdminTask?action=eliminar&id_task=<c:out value="${tarea.id_task}"/>" data-toggle="tooltip" data-original-title="Close"> <i class="fa fa-close text-danger"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								</table>
								</div>
                            
                            <!-- END MAGIC HERE -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2020 &copy; My Planner </footer>
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
