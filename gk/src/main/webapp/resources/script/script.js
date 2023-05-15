const newArticleBtn = document.querySelector("#newArticleBtn");

newArticleBtn.onclick = () =>{
	location.href="/boardInsertForm";
}


const insertBtn = document.querySelector("#insertBtn");

insertBtn.onclick = (e) =>{
	e.submit();
}
