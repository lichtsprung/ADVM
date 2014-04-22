angular.module('management_courses',[]).controller('management_courses_controller', ($scope, $http) ->
  $scope.master = {}
  $scope.result = {}

  $scope.addCourse = (course) ->
    courseJson =
      name : course.name
      id : course.id
      programmes : [course.programmes]

    $http.post("/course", courseJson)
    $scope.reset()

  $scope.reset = () ->
    $scope.add = angular.copy($scope.master)
    $scope.find = angular.copy($scope.master)

  $scope.findCourse = (find) ->
    $http.get("/course/#{find.id}").success((data, status, headers, config) ->
      $scope.result.id = data.id
      $scope.result.name = data.name
      $scope.result.programmes = data.programmes
    )
)