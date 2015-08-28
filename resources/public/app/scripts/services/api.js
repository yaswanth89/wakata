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
      }
      //getScheduleForRoom: function (roomid,from,to) {
      //  var deferred = $q.defer();
      //  $http.get(apiRoute + '/schedule',{
      //    params:{
      //      roomid:1,
      //      fromTime:from,
      //      toTime:to
      //    }
      //  }).success(function (data) {
      //    deferred.resolve(data);
      //  });
      //  return deferred.promise;
      //}
    };
    return api;
  });
