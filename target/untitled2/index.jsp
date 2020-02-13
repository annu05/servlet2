<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>App association</title>
    <script type="text/javascript">
        function associate() {
            document.forms[0].action = "loginServlet";
            document.forms[0].submit();
        }
        function disassociate()
        {
            document.forms[0].action = "disassociate";
            document.forms[0].submit();

        }
        function test()
        {
            document.forms[0].action = "test";
            document.forms[0].submit();

        }
    </script>
    <style>
        body
        {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: url("https://images.hdqwalls.com/download/alaska-glacier-ice-mountains-xy-2560x1440.jpg");
            background-size: cover;
        }
        .box
        {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            width: 400px;
           padding: 40px;
            background: rgba(0,0,0,0.8);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0,0,0,0.5);
            border-radius: 10px;
        }
        .box h2
        {
            margin: 0 0 30px ;
            padding: 0;
            color: #fff;
            text-align: center;
        }
        .box .inputBox
        {
            position: relative;
        }
        .box .inputBox input
        {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            letter-spacing: 1px;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }
        .box .inputBox label
        {
            position: absolute;
            top: 0;
            left: 0;
            letter-spacing: 1px;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }
        .box .inputBox input:focus ~ label,
        .box .inputBox input:valid ~ label
        {
            top: -18px;
            left: 0;
            color: #03a9f4;
            font-size: 12px;
        }
        .box input[type="submit"]
        {
            background: transparent;
            border: none;
            outline: none ;
            color: #fff;
            background: #03a9f4;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;

        }

    </style>
</head>
<body>
<div class="box">
    <h2>Apple App Call</h2>
<form name="loginForm" method="post" >
    <div class="inputBox">
         <input type="text" name="appid" required=""/>
        <label>AppID</label>
    </div>
    <div class="inputBox">
        <input type="text" name="serialno" required=""/>
        <label>SerialNo</label>
    </div>
    <input type="submit" value="Associate" onclick="associate();" />
    <input type="submit" value="Disassociate" onclick="disassociate();"/>
    <input type="submit" value="Test" onclick="test();"/>

</form>
</div>
</body>
</html>
