<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <h4 class="page-title">Favoritos </h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12"> <a href="#" target="_blank" class="btn btn-danger pull-right m-l-20 btn-rounded btn-outline hidden-xs hidden-sm waves-effect waves-light"><i class="fa fa-refresh fa-fw" aria-hidden="true"></i></a>
                        <ol class="breadcrumb">
                            <li><a href="inicio">Planner</a></li>
                            <li><a href="AdminFavorite?action=mostrar">Favoritos</a></li>
                            <li class="active">Mis Favoritos</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                
                </div>
				
					<div class="row">
						<div class="col-md-12">
		                    <div class="white-box">
		                    	<a href="AdminFavorite?action=nuevo" class="btn btn-info btn-circle" style="float: right;"><i class="fa fa-plus"></i></a>
		                        <h3 class="box-title">Mis Favoritos</h3>
                                <form action="AdminFavorite?action=filtrar" method="post">
	                                <div class="form-group">
	                                    <label for="exampleInputpwd1">Categoría</label>
	                                    <div class="input-group">
	                                        <div class="input-group-addon"><i class="fa fa-arrows-v"></i></div>
	                                          <select name="category" id="category" class="form-control">
			                                      <option>Todos</option>
			                                      <option>Libro</option>
			                                      <option>Película</option>
			                                      <option>Lugar</option>
			                                      <option>Restaurante</option>
			                                      <option>Serie</option>
			                                      <option>Ropa</option>
	                                			</select>
	                                		</div>
	                                </div>
	                             	
	                                <button type="submit" name="btn-action" class="btn btn-megna waves-effect waves-light m-r-10">Filtrar</button>
	                            	</form>
	                            	<br> 
		                     </div>
		                 </div>
		             </div>
									<c:forEach var="favorito" items="${listFavs}">
					                    <div class="col-lg-4 col-sm-4">
					                        <div class="panel panel-default">
					                            <div class="panel-heading"> <c:out value="${favorito.name}"/>
					                                <div class="pull-right"><a href="#" data-perform="panel-collapse"><i class="fa fa-plus"></i></a>  </div>
					                            </div>
					                            <div class="panel-wrapper collapse out" aria-expanded="false">
					                                <div class="panel-body">
					                                    <p><strong>Categoria: </strong><c:out value="${favorito.category}"/></p>
					                                    <p><strong>Referencia: </strong><c:out value="${favorito.reference}"/></p>
					                                    <p><strong>Comentario: </strong><c:out value="${favorito.comment}"/></p>

					                                </div>
					                                <div class="panel-footer"><a href="AdminFavorite?action=editar&id_fav=${favorito.id_fav}" data-toggle="tooltip" data-original-title="Edit"> <i class="fa fa-pencil text-inverse m-r-10"></i> </a><a href="AdminFavorite?action=eliminar&id_fav=<c:out value="${favorito.id_fav}"/>" data-toggle="tooltip" data-original-title="Close"> <i class="fa fa-close text-danger"></i></a>
													</div>
					                            </div>
					                        </div>
					                    </div>
					                   </c:forEach>
				                   
                <!-- <div class="row">
                    <div class="col-md-12">
                        <div class="white-box">
                            <h3 class="box-title">Mis Favoritos</h3>
                            <a href="AdminFavorite?action=nuevo" class="btn btn-success btn-circle" style="float: right;"><i class="fa fa-plus"></i></a>
                            <br><br> 
                            <!-- DO MAGIC HERE 
                            
                            <div class="table-responsive">
                            <table class="table color-table info-table">
                            <thead>
	                            <tr>
									<th>#</th>
									<th>Categoria</th>
									<th>Nombre</th>
									<th>Referencia</th>
									<th>Comentario</th>
									<th colspan=2>ACCIONES</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="favorito" items="${listFavs}">
									<tr>
										<td><c:out value="${favorito.id_fav}"/></td>
										<td><c:out value="${favorito.category}"/></td>
										<td><c:out value="${favorito.name}"/></td>
										<td><c:out value="${favorito.reference}"/></td>
										<td><c:out value="${favorito.comment}"/></td>
										<td class="text-nowrap">
											<a href="AdminFavorite?action=editar&id_fav=${favorito.id_fav}" data-toggle="tooltip" data-original-title="Edit"> <i class="fa fa-pencil text-inverse m-r-10"></i> </a>
											<a href="AdminFavorite?action=eliminar&id_fav=<c:out value="${favorito.id_fav}"/>" data-toggle="tooltip" data-original-title="Close"> <i class="fa fa-close text-danger"></i></a>
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
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2020 &copy; My Planner </footer>
        <!-- /#page-wrapper -->
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
