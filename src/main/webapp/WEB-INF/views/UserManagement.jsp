<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>  
        <title>AngularJS $http Example</title>  
        <style>
            .actfijo.ng-valid {
                background-color: lightgreen;
            }
            .actfijo.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .actfijo.ng-dirty.ng-invalid-minlength {
                background-color: yellow;
            }



        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body ng-app="myApp" class="ng-cloak">
        <div class="generic-container" ng-controller="ActFijosController as ctrl">

            Language : <a href="?lang=en">English</a> | <a href="?lang=es">Español</a>

            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead"><spring:message code="Title.actfijo.regform" /></span></div>
                <div class="formcontainer">
                    <form name="myForm" ng-submit="ctrl.submit()" class="form-horizontal">

                        <spring:message code="Message.actfijo.serialnii_inf" var="snii"/>
                        <input type="hidden" ng-model="ctrl.actfijo.serial" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">SerialNII</label>
                                <div class="col-md-7">

                                    <input type="text" ng-model="ctrl.actfijo.serialNII" name="aserialnii" class="actfijo form-control input-sm" placeholder="${snii}" required/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.aserialnii.$error.required"><spring:message code="Message.reqfield"/></span>
                                        <span ng-show="myForm.aserialnii.$invalid"><spring:message code="Message.blfield"/></span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <spring:message code="Message.actfijo.nombre_inf" var="anombre"/>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Nombre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.nombre" class="actfijo form-control input-sm" placeholder="${anombre}"required/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.aserialnii.$error.required"><spring:message code="Message.reqfield"/></span>
                                        <span ng-show="myForm.aserialnii.$invalid"><spring:message code="Message.blfield"/></span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Descripcion</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.descripcion" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Tipo</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.tipo" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>
                        </div>       

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Peso</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.peso" class="form-control input-sm" placeholder="<spring:message code="Message.formdouble"/>"/>
                                </div>
                            </div>
                        </div>            


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Alto</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.alto" class="form-control input-sm" placeholder="<spring:message code="Message.formdouble"/>"/>
                                </div>
                            </div>
                        </div>            

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Ancho</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.ancho" class="form-control input-sm" placeholder="<spring:message code="Message.formdouble"/>"/>
                                </div>
                            </div>
                        </div>   

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Largo</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.largo" class="form-control input-sm" placeholder="<spring:message code="Message.formdouble"/>"/>
                                </div>
                            </div>
                        </div>   

                        <div class="row">
                            <div class="form-group col-md-12">                            

                                <label class="col-md-2 control-lable" for="file">Valor de Compra</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.valorcompra" class="form-control input-sm" placeholder="<spring:message code="Message.formdouble"/>"/>
                                </div>
                            </div>
                        </div>  

                        <spring:message code="Message.actfijo.fechacompra_inf" var="fecha_compra"/>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Fecha de Compra</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.fechacompra" class="actfijo form-control input-sm" placeholder="${fecha_compra}" required ng-minlength="10"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.aserialnii.$error.required"><spring:message code="Message.reqfield"/></span>
                                        <span ng-show="myForm.uname.$error.minlength">Minimum length required is 10</span> 
                                        <span ng-show="myForm.aserialnii.$invalid"><spring:message code="Message.blfield"/></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Fecha de Baja</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.fechabaja" class="form-control input-sm" placeholder="<spring:message code="Message.formdate"/>"/>
                                </div>
                            </div>
                        </div> 

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Estado Actual</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.estadoactual" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>
                        </div> 

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Color</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.color" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>
                        </div> 

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Id Per</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.idPer2" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>

                        </div> 

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Id Area</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.actfijo.idArea2" class="form-control input-sm" placeholder=""/>
                                </div>
                            </div>
                        </div>                         



                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit"  value="{{!ctrl.actfijo.serial ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="panel panel-default">

                <div class="panel-heading"><span class="lead"><spring:message code="Title.actfijo.consultaslist"/></span></div>

                <select class="browser-default custom-select" name="multipleSelect" id="multipleSelect" ng-model="ctrl.consulta.tipo" multiple>
                    <option selected>Escoger Tipo</option>
                    <option value="serial">Serial</option>
                    <option value="tipo">Tipo</option>
                    <option value="fechacompra">Fecha de Compra</option>
                </select><br>
               
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Valor</label>
                                <div class="col-md-7">
                                     <input type="text" ng-model="ctrl.consulta.valor" class="form-control input-sm" placeholder=""/>
                 <button type="button" ng-click="ctrl.consultar(ctrl.consulta.tipo, ctrl.consulta.valor)" class="btn btn-success custom-width">Consult</button>
                                </div>
                            </div>
                        </div>  

              
</br>  
 <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Serial</th>
                            <th>SerialNII</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Tipo</th>
                            <th>Peso</th>
                            <th>Alto</th>
                            <th>Ancho</th>
                            <th>Largo</th>
                            <th>Valor Compra</th>
                            <th>Fecha Compra</th>
                            <th>Fecha Baja</th>
                            <th>Estado Actual</th>
                            <th>Color</th>
                            <th>IdPer2</th>
                            <th>IdArea2</th>


                            <th width="20%"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr ng-repeat="a in ctrl.actfijos2">
                            <td><span ng-bind="a.serial"></span></td>
                            <td><span ng-bind="a.serialNII"></span></td>
                            <td><span ng-bind="a.nombre"></span></td>
                            <td><span ng-bind="a.descripcion"></span></td>
                            <td><span ng-bind="a.tipo"></span></td>
                            <td><span ng-bind="a.peso"></span></td>
                            <td><span ng-bind="a.alto"></span></td>
                            <td><span ng-bind="a.ancho"></span></td>
                            <td><span ng-bind="a.largo"></span></td>
                            <td><span ng-bind="a.valorcompra"></span></td>
                            <td><span ng-bind="a.fechacompra"></span></td>
                            <td><span ng-bind="a.fechabaja"></span></td>
                            <td><span ng-bind="a.estadoactual"></span></td>
                            <td><span ng-bind="a.color"></span></td>
                            <td><span ng-bind="a.idPer2"></span></td>
                            <td><span ng-bind="a.idArea2"></span></td>

                        </tr>
                    </tbody>
                </table>
            </div>                
                
                

        </div>



        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="Title.actfijo.actfijolist"/></span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>

                            <th>Serial</th>
                            <th>SerialNII</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Tipo</th>
                            <th>Peso</th>
                            <th>Alto</th>
                            <th>Ancho</th>
                            <th>Largo</th>
                            <th>Valor Compra</th>
                            <th>Fecha Compra</th>
                            <th>Fecha Baja</th>
                            <th>Estado Actual</th>
                            <th>Color</th>
                            <th>IdPer2</th>
                            <th>IdArea2</th>


                            <th width="20%"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr ng-repeat="u in ctrl.actfijos">
                            <td><span ng-bind="u.serial"></span></td>
                            <td><span ng-bind="u.serialNII"></span></td>
                            <td><span ng-bind="u.nombre"></span></td>
                            <td><span ng-bind="u.descripcion"></span></td>
                            <td><span ng-bind="u.tipo"></span></td>
                            <td><span ng-bind="u.peso"></span></td>
                            <td><span ng-bind="u.alto"></span></td>
                            <td><span ng-bind="u.ancho"></span></td>
                            <td><span ng-bind="u.largo"></span></td>
                            <td><span ng-bind="u.valorcompra"></span></td>
                            <td><span ng-bind="u.fechacompra"></span></td>
                            <td><span ng-bind="u.fechabaja"></span></td>
                            <td><span ng-bind="u.estadoactual"></span></td>
                            <td><span ng-bind="u.color"></span></td>
                            <td><span ng-bind="u.idPer2"></span></td>
                            <td><span ng-bind="u.idArea2"></span></td>
                            <td>
                                <button type="button" ng-click="ctrl.edit(u.serial)" class="btn btn-success custom-width">Edit</button>      <button type="button" ng-click="ctrl.remove(u.serial)" class="btn btn-danger custom-width">Remove</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="Title.actfijo.personlist"/></span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>

                            <th>Id Persona</th>
                            <th>Nombre</th>

                            <th width="20%"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr ng-repeat="p in ctrl.personas">
                            <td><span ng-bind="p.idPersona"></span></td>
                            <td><span ng-bind="p.nombrePersona"></span></td>

                        </tr>
                    </tbody>
                </table>
            </div>
        </div>             


        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="Title.actfijo.arealist"/></span></div>
            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                        <tr>

                            <th>Id Area</th>
                            <th>Nombre</th>
                            <th>Ciudad</th>

                            <th width="20%"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr ng-repeat="a in ctrl.areas">
                            <td><span ng-bind="a.idArea"></span></td>
                            <td><span ng-bind="a.nombreArea"></span></td>
                            <td><span ng-bind="a.ciudad"></span></td>

                        </tr>
                    </tbody>
                </table>
            </div>
        </div>                                  



    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/actfijos_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/actfijos_controller.js' />"></script>
</body>
</html>