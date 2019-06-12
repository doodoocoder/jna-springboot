package org.demo.demo;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class Testx {
    public static void main(String[] args) throws DocumentException {
        String xml="<tem:ArrayOfString xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "               xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                "               xmlns:tem=\"http://WebXml.com.cn/\">\n" +
                "    <tem:string>浙江</tem:string>\n" +
                "    <tem:string>杭州</tem:string>\n" +
                "    <tem:string>58457</tem:string>\n" +
                "    <tem:string>58457.jpg</tem:string>\n" +
                "    <tem:string>2016-3-22 17:57:12</tem:string>\n" +
                "    <tem:string>11℃/16℃</tem:string>\n" +
                "    <tem:string>3月22日 阵雨</tem:string>\n" +
                "    <tem:string>东南风微风</tem:string>\n" +
                "    <tem:string>3.gif</tem:string>\n" +
                "    <tem:string>3.gif</tem:string>\n" +
                "    <tem:string>今日天气实况：气温：13℃；风向/风力：南风 1级；湿度：81%；紫外线强度：弱。空气质量：良。</tem:string>\n" +
                "    <tem:string>\n" +
                "        紫外线指数：弱，辐射较弱，涂擦SPF12-15、PA+护肤品。 感冒指数：较易发，天凉，湿度大，较易感冒。 穿衣指数：较冷，建议着厚外套加毛衣等服装。 洗车指数：不宜，有雨，雨水和泥水会弄脏爱车。\n" +
                "        运动指数：较不宜，有降水，推荐您在室内进行休闲运动。 空气污染指数：良，气象条件有利于空气污染物扩散。\n" +
                "    </tem:string>\n" +
                "    <tem:string>6℃/12℃</tem:string>\n" +
                "    <tem:string>3月23日 阵雨转阴</tem:string>\n" +
                "    <tem:string>东北风3-4级</tem:string>\n" +
                "    <tem:string>3.gif</tem:string>\n" +
                "    <tem:string>2.gif</tem:string>\n" +
                "    <tem:string>5℃/13℃</tem:string>\n" +
                "    <tem:string>3月24日 多云</tem:string>\n" +
                "    <tem:string>北风3-4级</tem:string>\n" +
                "    <tem:string>1.gif</tem:string>\n" +
                "    <tem:string>1.gif</tem:string>\n" +
                "    <tem:string>\n" +
                "        杭州市是浙江省省会，国务院确定的全国重点风景旅游城市和历史文化名城，位于北纬30°16’、东经120°12’，地处长江三角洲南翼，杭州湾西端，钱塘江下游，京杭大运河南端，东濒杭州湾、钱塘江，南与金华市、衢州市、绍兴市相接，西与安徽省黄山市交界，北与湖州市、嘉兴市相邻。下辖8个区、5个县（市），全市总面积16596平方千米，其中市区面积3068平方千米。改革开放以来，杭州经济发展迅猛，2007年全市实现国内生产总值4103.89亿元，人均GDP达8063美元，连续17年保持2位数增长，连续4年被誉为“中国最具幸福感的城市”。\n" +
                "        杭州尤以西湖秀丽迷人的自然风光闻名于世。美丽的西湖三面环山，一面濒城，两堤卧波，三岛浮水，风景秀丽，四季异色，古迹珠连，名人荟萃，历代诗人吟咏不绝。杭州自然景观和人文景观十分丰富，文物、古迹众多，古代庭、园、楼、阁、塔、寺、泉、壑、石窟、摩崖碑刻遍布，众多景点或诡异神秘、内蕴深沉，或珠帘玉带、烟柳画桥，或万千姿态、蔚然奇观，或山青水秀、风情万般。全市现有60多个对外开放景点和40多处重点文物保护单位，以灵隐寺、六和塔、飞来峰、岳庙、西泠印社、三潭印月、花港观鱼、龙井、虎跑等最为著名。\n" +
                "    </tem:string>\n" +
                "</tem:ArrayOfString>";
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes()));
        HashMap map = new HashMap();
        Element rootElm = document.getRootElement();

        System.out.println(rootElm.getNamespaceURI());
        map.put("tem",rootElm.getNamespaceURI());
        // 创建解析路径，就是在普通的解析路径前加上map里的key值
        XPath xPath = document.createXPath("//tem:ArrayOfString/tem:string");
        xPath.setNamespaceURIs(map);
        List<Node> nodes2 = xPath.selectNodes(document);
        for(Node n:nodes2){
            System.out.println(n.getText());
        }
    }
}
