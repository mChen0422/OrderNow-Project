import React, { forwardRef } from "react";
import { Form, Upload, Input } from "antd";
import { InboxOutlined } from "@ant-design/icons";

export const PostForm = forwardRef((props, formRef) => {
  const formItemLayout = {
    labelCol: { span: 6 },
    wrapperCol: { span: 14 }
  };
  
  return (
    <Form name="validate_other" {...formItemLayout} ref={formRef}>
      
      <Form.Item
          name="Comments"
          label = "Message"
          rules={[{ required: true, message: "Please input your comments!" }]}
        >
          <Input />
          
        </Form.Item>
      
    </Form>
  );
});


