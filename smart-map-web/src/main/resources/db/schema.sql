create table if not exists map_history (
ID int not null primary key auto_increment,
USE_ID varchar(100),
title
point
url
detailUrl
address
city
province
phoneNumber
postcode
distance
tag
create_time DATE,



  title: results[x].Br[i].title,
                                point: results[x].Br[i].point.lng + "，" + results[x].Br[i].point.lat,
                                url: results[x].Br[i].url,
                                detailUrl: results[x].Br[i].detailUrl,
                                address: results[x].Br[i].address,
                                city: results[x].Br[i].city,
                                province: results[x].Br[i].province,
                                phoneNumber: results[x].Br[i].phoneNumber,
                                postcode: results[x].Br[i].postcode,
                                type: results[x].Br[i].type,
                                isAccurate: results[x].Br[i].isAccurate,
                                distance: distance,
                                keyword: results[x].keyword,
                                tag: 0