package com.example.culinaryndo.ui.bookmark

//class BookmarkAdapter: ListAdapter<FoodItems, BookmarkAdapter.MyViewHolder>(DIFF_CALLBACK)  {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = BookmarkItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val food = getItem(position)
//        holder.bind(food)
//    }
//
//    class MyViewHolder(val binding: BookmarkItemBinding): RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(users: FoodItems){
//
//        }
//    }
//    companion object{
//        val DIFF_CALLBACK= object : DiffUtil.ItemCallback<FoodItems>(){
//            override fun areItemsTheSame(oldItem: FoodItems, newItem: FoodItems): Boolean {
//                return  oldItem == newItem
//            }
//            override fun areContentsTheSame(oldItem: FoodItems, newItem: FoodItems): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}
