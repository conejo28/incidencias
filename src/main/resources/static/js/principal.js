/**
 * Created by IanDaniel on 27/09/2015.
 */
angular.module("principal",[])
.controller("ctrlPrincipal",function($scope){
     console.log("Probando el controlador")
        $scope.nombre;

        $scope.checar=function(){
            console.log("El nombre seleccionado es:"+$scope.nombre);
        }
    })