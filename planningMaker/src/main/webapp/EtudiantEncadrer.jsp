<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="pcoded-content">
                    <div class="pcoded-inner-content">

                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                            <div class="page-body m-t-40">
                                <!-- Page-header start -->
                                <div class="page-header card">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <i class="icofont icofont-table bg-c-blue"></i>
                                                <div class="d-inline">
                                                    <h4>Etudiants Encadrer</h4>
                                                    <span>les étudiants que vous encadrer </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="index.html">
                                                            <i class="icofont icofont-home"></i>
                                                        </a>
                                                    </li>
                                                    <li class="breadcrumb-item"><a href="#!">Consulter</a>
                                                    </li>
                                                    <li class="breadcrumb-item"><a href="#!">Liste Agnt administratif</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->

                                <!-- Page-body start -->
                                <div class="page-body">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <!-- Zero config.table start -->
                                            <div class="card">
                                                <div class="card-header">
                                                    <div class="card-header-right"><i
                                                            class="icofont icofont-spinner-alt-5"></i></div>
                                                </div>
                                                <div class="card-block">
                                                    <div class="dt-responsive table-responsive">
                                                        <table id="simpletable"
                                                               class="table table-striped table-bordered nowrap">
                                                            <thead>
                                                            <tr>
                                                            	<th>Etudiant</th>
                                                                <th>Sujet</th>
                                                                <th>Taux</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                        <c:forEach items="${ affectations }" var="affect">
                                                          <c:forEach items="${ etudiants }" var="etud">
                                                           <c:forEach items="${ sujets }" var="suj">
                                                           <c:if test="${affect.id_Etudiant == etud.id }">
                                                           <c:if test="${affect.id_Sujet == suj.id }">
															<tr>
																<td>${ etud.nom} ${ etud.prenom}</td>								
																<td>${suj.titre}</td>
																<td>
														<div class="progress-box">
                                                            
                                                            <div class="progress d-inline-block" style="width:100%">
                                                                <div class="progress-bar bg-c-green" style="width:${etud.taux}%"><label>${etud.taux}%</label></div>
                                                            </div>
                                                        </div>
																</td>	
															</tr>
															</c:if>
															</c:if>
															</c:forEach>
														  </c:forEach>
														</c:forEach>
                                                            </tbody>
                                                            <tfoot>
                                                           
                                                            </tfoot>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                              </div>
                        </div>
                    </div>
                    </div>
                </div>
        </div>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>