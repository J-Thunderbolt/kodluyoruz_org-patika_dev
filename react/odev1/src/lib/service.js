import axios from "axios";

const getData = async (userId) => {
    try {
        const { data: user } = await axios(
            `https://jsonplaceholder.typicode.com/users/${userId}`
        );
        const { data: posts } = await axios(
            `https://jsonplaceholder.typicode.com/posts?userId=${userId}`
        );
        // return { ...user, posts: [...posts] };
        return { user, posts };
    } catch (err) {
        return err;
    }
};

export default getData;