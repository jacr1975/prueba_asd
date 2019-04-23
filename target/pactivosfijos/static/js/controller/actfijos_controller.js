'use strict';

angular.module('myApp').controller('ActFijosController', ['$scope', 'ActFijosService', function ($scope, ActFijosService) {
        var self = this;
        self.actfijo = {serial: null, serialNII: '', nombre: '', descripcion: '', tipo: '', peso: '', alto: '', ancho: '',
            largo: '', valorcompra: '', fechacompra: '', fechabaja: '', estadoactual: '', color: '', idPer2: '', idArea2: ''};
        
         self.consulta = {tipo: '', valor:''};       
        self.actfijos = [];
        self.actfijos2 = [];
        self.personas = [];
        self.areas = [];

        self.submit = submit;
        self.edit = edit;
        self.consultar=consultar;
        self.remove = remove;
        self.reset = reset;


        fetchAllActFijos();

        function fetchAllActFijos() {
            ActFijosService.fetchAllActFijos()
                    .then(
                            function (d) {
                                self.actfijos = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Users');
                            }
                    );
        }

        listaPersonas();

        function listaPersonas() {
            ActFijosService.listaPersonas()
                    .then(
                            function (d) {
                                self.personas = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Personas');
                            }
                    );
        }

        listaAreas();

        function listaAreas() {
            ActFijosService.listaAreas()
                    .then(
                            function (d) {
                                self.areas = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Areas');
                            }
                    );
        }


        function listaConsulta(tipo, tipo2) {
            ActFijosService.listaConsulta(tipo, tipo2)
                    .then(
                            function (d) {
                               
                                self.actfijos2 = d;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Consulta');
                            }
                    );
        }

        function createActFijo(actfijo) {
            ActFijosService.createActFijo(actfijo)
                    .then(
                            fetchAllActFijos,
                            function (errResponse) {
                                console.error('Error while creating User');
                            }
                    );
        }


        function updateActFijo(actfijo, serial) {
            ActFijosService.updateActFijo(actfijo, serial)
                    .then(
                            fetchAllActFijos,
                            function (errResponse) {
                                console.error('Error while updating Activo Fijo');
                            }
                    );
        }

        function deleteActFijo(serial) {
            ActFijosService.deleteActFijo(serial)
                    .then(
                            fetchAllActFijos,
                            function (errResponse) {
                                console.error('Error while deleting Activo Fijo');
                            }
                    );
        }

        function submit() {
            if (self.actfijo.serial === null) {
                console.log('Saving New Activo Fijo', self.actfijo);
                createActFijo(self.actfijo);
            } else {
                updateActFijo(self.actfijo, self.actfijo.serial);
                console.log('Activo Fijo updated with id ', self.actfijo.serial);
            }
            reset();
        }

        function edit(serial) {
            console.log('id to be edited', serial);
            for (var i = 0; i < self.actfijos.length; i++) {
                if (self.actfijos[i].serial === serial) {
                    self.actfijo = angular.copy(self.actfijos[i]);
                    break;
                }
            }
        }

        function consultar(tipo,valor ) {
            console.log('tipo to be consulted ');

            listaConsulta(tipo, valor);
        }

        function remove(serial) {
            console.log('id to be deleted', serial);
            if (self.actfijo.serial === serial) {//clean form if the user to be deleted is shown there.
                reset();
            }
            deleteActFijo(serial);
        }

        function reset() {
            self.actfijo = {serial: null, serialNII: '', nombre: '', descripcion: '', tipo: '', peso: '', alto: '', ancho: '',
                largo: '', valorcompra: '', fechacompra: '', fechabaja: '', estadoactual: '', color: '', idPer2: '', idArea2: ''};
            $scope.myForm.$setPristine(); //reset Form
        }

    }]);
