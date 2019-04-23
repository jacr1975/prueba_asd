'use strict';

angular.module('myApp').factory('ActFijosService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:12566/pactivosfijos/actfijo/';
    var REST_SERVICE_URI2 = 'http://localhost:12566/pactivosfijos/actfijo/listaper';
    var REST_SERVICE_URI3 = 'http://localhost:12566/pactivosfijos/actfijo/listaarea';
    var REST_SERVICE_URI4 = 'http://localhost:12566/pactivosfijos/actfijo/listaconsulta/';

    var factory = {
        fetchAllActFijos: fetchAllActFijos,
        listaPersonas:listaPersonas,
        listaAreas:listaAreas,
        listaConsulta:listaConsulta,
        createActFijo: createActFijo,
        updateActFijo:updateActFijo,
        deleteActFijo:deleteActFijo
    };

    return factory;

    function fetchAllActFijos() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Activos Fijos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function listaPersonas() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI2)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Personas');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function listaAreas() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI3)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Areas');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function listaConsulta(tipo, valor) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI4+tipo+'/'+valor)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Consulta');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createActFijo(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Activo Fijo');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateActFijo(user, serial) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+serial, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Activo Fijo');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteActFijo(serial) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+serial)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Activo Fijo');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


}]);
