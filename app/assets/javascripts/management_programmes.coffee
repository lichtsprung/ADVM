angular.module('management_programmes',[]).controller('management_programmes_controller', ($scope, $http) ->
  $scope.master = {}
  $scope.result = {}

  $scope.addProgramme = (programme) ->
    programmeJson =
      firstname : programme.firstname
      lastname : programme.lastname
      registrationNumber : programme.registrationNumber
      id : programme.id
    $http.post("/student", programmeJson)
    $scope.reset()

  $scope.reset = () ->
    $scope.add = angular.copy($scope.master)
    $scope.find = angular.copy($scope.master)

  $scope.findProgramme = (find) ->
    $http.get("/programme/#{find.id}").success((data, status, headers, config) ->
      $scope.result.firstname = data.firstname
      $scope.result.lastname = data.lastname
      $scope.result.registrationNumber = data.registrationNumber
      $scope.result.id = data.id
    )
)