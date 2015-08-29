'use strict';

/**
 * @ngdoc service
 * @name publicApp.api
 * @description
 * # api
 * Service in the publicApp.
 */
angular.module('publicApp')
  .service('api', function ($q,$http) {
    var apiRoute = 'http://localhost:3000/api';

    var api = {
      allRooms: function () {
        var deferred = $q.defer();
        $http.get(apiRoute + '/rooms').success(function (data) {
          deferred.resolve(data);
        });
        return deferred.promise;
      },
      getScheduleForRoom: function (roomid,from,to,at) {
        var deferred = $q.defer();
        $http.get(apiRoute + '/schedule',{
          params:{
            room:roomid,
            from:from,
            to:to,
            at:at
          }
        }).success(function (data) {
          deferred.resolve(data);
        });
        return deferred.promise;
      },
      makeBooking: function (roomid,slot,date,doneby,description){
        var deferred = $q.defer();
        $http.post(apiRoute + '/book',{
          room:roomid,
          slot:slot,
          date:date,
          doneby:doneby,
          description:description
        }).success(function (data) {
          deferred.resolve(data);
        });
        return deferred.promise;
      },
      createRoom: function(roomName){
        var deferred = $q.defer();
        $http.post(apiRoute+'/create',{
          roomName:roomName
        }).success(function(data){
          deferred.resolve(data);
        });
        return deferred.promise;
      }
    };
    return api;
  });
