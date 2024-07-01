import WebView from "react-native-webview";

const Screen4 = () => {
    return <WebView source={{ uri: 'https://bhavanshudalwadi.netlify.app' }} style={{ flex: 1 }} />;
    // return <WebView source={{ html: `
    //     <style>
    //         .btn {
    //             background-color: '#000';
    //             color: '#fff';
    //             border-radius: 20px;
    //             width: 400px;
    //             height: 100px;
    //             font-size: 40px;
    //         }
    //         .btn:focus {
    //             background-color: '#000';
    //         }
    //     </style>
    //     <button class="btn">Say Hello</button>
    // ` }} style={{ flex: 1 }} />;
};

export default Screen4;