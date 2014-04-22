angular.module('management_students',[]).controller('management_students_controller', ($scope, $http) ->
  $scope.master = {}
  $scope.result = {}
  $scope.degreeProgramme = "Studiengang"

  $scope.addStudent = (student) ->
    student =
      firstname : student.firstname
      lastname : student.lastname
      registrationNumber : student.registrationNumber
      id : student.id
      degreeProgramme : student.degreeProgramme
    alert(student.degreeProgramme)
    $http.post("/student", student)
    $scope.reset()

  $scope.reset = () ->
    $scope.add = angular.copy($scope.master)
    $scope.find = angular.copy($scope.master)
    $scope.degreeProgramme = "Studiengang"

  $scope.findStudent = (find) ->
    $http.get("/student/#{find.id}").success((data, status, headers, config) ->
      $scope.result.firstname = data.firstname
      $scope.result.lastname = data.lastname
      $scope.result.registrationNumber = data.registrationNumber
      $scope.result.id = data.id
      $scope.result.degreeProgramme = data.degreeProgramme
    )



)



