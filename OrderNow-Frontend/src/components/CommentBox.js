import { Button, Card, Divider, List, message, Select, Tooltip,Comment } from "antd";
import { useEffect, useState } from "react";
import moment from 'moment';
import { addItemToCart,getCommentsById } from "../utils";
import { PlusOutlined } from "@ant-design/icons";
import '../index.css';


const CommentBox =({foodid}) => 
{
    const [foodId,setFoodid] = useState(foodid);
    const [comments,setComments] = useState([])
    useEffect(
        ()=>{
            if(!foodId)
            {
                return
            }
            
            getCommentsById(foodid).then((data)=>{setComments(data);})
                //console.log(data,"food comments ",`${data[0].publishedTimestamp.year}-${data[0].publishedTimestamp.monthValue}-${data[0].publishedTimestamp.dayOfMonth}`)})
                  .catch((err)=>{
                    message.error(err.message);
                  }).finally(()=>{})
            },[foodId]
    );
    return (
      
        <List
          className="comment-list"
          
          itemLayout="horizontal"
          dataSource={comments}
          renderItem={(item) => (
            <li>
              <Comment
                author={item.custormerName}
                content={item.yourComment}
                avatar = 'https://joeschmoe.io/api/v1/random'
                datetime = 
                  {<Tooltip>
                    <span>{moment(`${item.publishedTimestamp.year}-${item.publishedTimestamp.monthValue}-${item.publishedTimestamp.dayOfMonth}`).fromNow()}</span>

                  </Tooltip>}
              />
            </li>
          )}
        />
      );

}

export default CommentBox;