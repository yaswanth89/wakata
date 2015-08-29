'use strict';

/**
 * @ngdoc function
 * @name publicApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the publicApp
 */
angular.module('publicApp')
  .controller('AboutCtrl', function ($scope, $routeParams,$filter, $location, api) {
    var calculateDateOffset= function(date){
      var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
      var firstDate = $scope.startDate;
      var secondDate = new Date(date);
      return Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
    };
    $scope.roomID = $routeParams.roomID;
    $scope.startDate = new Date($routeParams.startDate);
    $scope.times = [
      {time:"9:00 - 10:00",book:["","","","","","",""]},
      {time:"10:00 - 11:00",book:["","","","","","",""]},
      {time:"11:00 - 12:00",book:["","","","","","",""]},
      {time:"12:00 - 13:00",book:["","","","","","",""]},
      {time:"14:00 - 15:00",book:["","","","","","",""]},
      {time:"15:00 - 16:00",book:["","","","","","",""]},
      {time:"16:00 - 17:00",book:["","","","","","",""]},
      {time:"18:00 - 19:00",book:["","","","","","",""]},
      {time:"19:00 - 20:00",book:["","","","","","",""]},
      {time:"20:00 - 21:00",book:["","","","","","",""]}];

    var st = angular.copy($scope.startDate);
    $scope.next_seven_days = [st.getTime()];

    for(var i=0;i<6;i++){
      $scope.next_seven_days.push(st.setDate(st.getDate() + 1));
    }

    $scope.from = new Date($scope.next_seven_days[0]).toISOString();
    $scope.to = new Date($scope.next_seven_days[6]).toISOString();


    api.getScheduleForRoom($scope.roomID,$scope.from,$scope.to,0).then(function(data){
      var l = data.length;
      for(var i=0;i<l;i++){
        var index = calculateDateOffset(data[i].date);
        var slot = data[i].slot;
        $scope.times[slot].book[index] = data[i].doneby;
      }
    });

    $scope.bookAt = function(slot,relDate){
      var bookingDate = angular.copy($scope.startDate);
      bookingDate.setDate(bookingDate.getDate() + relDate);
      var str = $filter('date')(bookingDate,"yyyy-MM-dd");
      $location.path("/make/"+$scope.roomID+"/"+str+"/"+slot);
    }
  });
