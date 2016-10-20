using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// CustomHandler 的摘要说明
/// </summary>
/// 
namespace CustomHandler
{
    public class JpgHandler : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
            String tokenID = context.Request["tokenId"];
            if (tokenID !=null )
            {
                context.Response.ContentType = "image/JPEG";
                context.Response.WriteFile("/meinv.jpg");
            }
            else
            {
                String responseString = @"<!DOCTYPE html>
                <html>
                <head >
                    <meta charset=""UTF-8"">
                    <title>error</title>
                </head>
                <body>
                    <div>
                        <h1>申请tokenId后才能访问图片</h1>
                    </div>
                </body>
                </html>
                    ";
                context.Response.ContentType = "text/html";
                context.Response.Write(String.Format(responseString,context.Request.UserAgent));
            }       
		
		 
        }

        public bool IsReusable
        {
            get { return true; }
        }
    }
}
