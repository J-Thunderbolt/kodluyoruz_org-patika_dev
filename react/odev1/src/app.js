import getData from "./lib/service.js";

let userId = 2;

// let userInfo = await getData(userId).then(response => response.user);
// let userPosts = await getData(userId).then(response => response.posts);
// let result = { ...userInfo, posts: [...userPosts] };
// console.log(result);

await getData(userId).then(response => console.log(response));

